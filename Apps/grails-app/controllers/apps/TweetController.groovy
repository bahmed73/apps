package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured
import groovy.util.logging.Log;

import java.security.Principal
//import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class TweetController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Tweet.list(params), model:[tweetCount: Tweet.count()]
    }

    def show(Tweet tweet) {
        respond tweet
    }

    def create() {
        respond new Tweet(params)
    }

    @Transactional
    def save(Tweet tweet) {
        if (tweet == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tweet.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tweet.errors, view:'create'
            return
        }

        tweet.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tweet.label', default: 'Tweet'), tweet.id])
                redirect tweet
            }
            '*' { respond tweet, [status: CREATED] }
        }
    }

    def edit(Tweet tweet) {
        respond tweet
    }

    @Transactional
    def update(Tweet tweet) {
        if (tweet == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tweet.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tweet.errors, view:'edit'
            return
        }

        tweet.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tweet.label', default: 'Tweet'), tweet.id])
                redirect tweet
            }
            '*'{ respond tweet, [status: OK] }
        }
    }

    @Transactional
    def delete(Tweet tweet) {

        if (tweet == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        tweet.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tweet.label', default: 'Tweet'), tweet.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tweet.label', default: 'Tweet'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
