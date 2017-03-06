package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CampaignController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Campaign.list(params), model:[campaignCount: Campaign.count()]
    }

    def show(Campaign campaign) {
        respond campaign
    }

    def create() {
        respond new Campaign(params)
    }

    @Transactional
    def save(Campaign campaign) {
        if (campaign == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (campaign.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond campaign.errors, view:'create'
            return
        }

        campaign.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'campaign.label', default: 'Campaign'), campaign.id])
                redirect campaign
            }
            '*' { respond campaign, [status: CREATED] }
        }
    }

    def edit(Campaign campaign) {
        respond campaign
    }

    @Transactional
    def update(Campaign campaign) {
        if (campaign == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (campaign.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond campaign.errors, view:'edit'
            return
        }

        campaign.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'campaign.label', default: 'Campaign'), campaign.id])
                redirect campaign
            }
            '*'{ respond campaign, [status: OK] }
        }
    }

    @Transactional
    def delete(Campaign campaign) {

        if (campaign == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        campaign.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'campaign.label', default: 'Campaign'), campaign.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'campaign.label', default: 'Campaign'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
