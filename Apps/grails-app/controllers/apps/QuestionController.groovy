package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class QuestionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Question.list(params), model:[questionCount: Question.count()]
    }

    def show(Question question) {
        respond question
    }

	def showAnswers(Question question) {
		if (question) {
			
			def app = question.app
			def answers = Answer.findAllByQuestion(question)
			def answerCount = answers.size()
			respond question, [model: [app: app, answers: answers, answerCount: answerCount]]
		} else if (params.questionId) {
			def questionId = params.questionId
			question = Question.get(questionId)
			
			def app = question.app
			def answers = Answer.findAllByQuestion(question)
			def answerCount = answers.size()
			respond question, [model: [app: app, answers: answers, answerCount: answerCount]]
		} else {
			redirect(action:"index")
		}
	}
	
	def answerQuestion() {
		if (params) {
			if (params.answer) {
				def answerText = params.answer
				
				if (params.question) {
					def questionId = params.question
					
					def question = Question.get(questionId)
					def answer = new Answer()
					answer.status = 1
					answer.name = answerText
					answer.app = question.app
					answer.createTime = new Date()
					answer.updateTime = new Date()
					answer.question = question
					
					answer.save flush:true
					
					redirect(action:"showAnswers", params: [questionId: question.id])
				}
			}
		} else {
			redirect(action:"index")
		}
	}
	
    def create() {
        respond new Question(params)
    }

    @Transactional
    def save(Question question) {
        if (question == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (question.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond question.errors, view:'create'
            return
        }

        question.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'question.label', default: 'Question'), question.id])
                redirect question
            }
            '*' { respond question, [status: CREATED] }
        }
    }

    def edit(Question question) {
        respond question
    }

    @Transactional
    def update(Question question) {
        if (question == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (question.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond question.errors, view:'edit'
            return
        }

        question.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'question.label', default: 'Question'), question.id])
                redirect question
            }
            '*'{ respond question, [status: OK] }
        }
    }

    @Transactional
    def delete(Question question) {

        if (question == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        question.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'question.label', default: 'Question'), question.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'question.label', default: 'Question'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
