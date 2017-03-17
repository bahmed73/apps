package apps

import grails.test.mixin.*
import spock.lang.*

@TestFor(DiscountController)
@Mock(Discount)
class DiscountControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.discountList
            model.discountCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.discount!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def discount = new Discount()
            discount.validate()
            controller.save(discount)

        then:"The create view is rendered again with the correct model"
            model.discount!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            discount = new Discount(params)

            controller.save(discount)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/discount/show/1'
            controller.flash.message != null
            Discount.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def discount = new Discount(params)
            controller.show(discount)

        then:"A model is populated containing the domain instance"
            model.discount == discount
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def discount = new Discount(params)
            controller.edit(discount)

        then:"A model is populated containing the domain instance"
            model.discount == discount
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/discount/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def discount = new Discount()
            discount.validate()
            controller.update(discount)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.discount == discount

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            discount = new Discount(params).save(flush: true)
            controller.update(discount)

        then:"A redirect is issued to the show action"
            discount != null
            response.redirectedUrl == "/discount/show/$discount.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/discount/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def discount = new Discount(params).save(flush: true)

        then:"It exists"
            Discount.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(discount)

        then:"The instance is deleted"
            Discount.count() == 0
            response.redirectedUrl == '/discount/index'
            flash.message != null
    }
}
