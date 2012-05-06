package placement

import org.springframework.dao.DataIntegrityViolationException

class PlacementOpportunitiesController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [placementOpportunitiesInstanceList: PlacementOpportunities.list(params), placementOpportunitiesInstanceTotal: PlacementOpportunities.count()]
    }

    def create() {
        [placementOpportunitiesInstance: new PlacementOpportunities(params)]
    }

    def save() {
        def placementOpportunitiesInstance = new PlacementOpportunities(params)
        if (!placementOpportunitiesInstance.save(flush: true)) {
            render(view: "create", model: [placementOpportunitiesInstance: placementOpportunitiesInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'placementOpportunities.label', default: 'PlacementOpportunities'), placementOpportunitiesInstance.id])
        redirect(action: "show", id: placementOpportunitiesInstance.id)
    }

    def show() {
        def placementOpportunitiesInstance = PlacementOpportunities.get(params.id)
        if (!placementOpportunitiesInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'placementOpportunities.label', default: 'PlacementOpportunities'), params.id])
            redirect(action: "list")
            return
        }

        [placementOpportunitiesInstance: placementOpportunitiesInstance]
    }

    def edit() {
        def placementOpportunitiesInstance = PlacementOpportunities.get(params.id)
        if (!placementOpportunitiesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'placementOpportunities.label', default: 'PlacementOpportunities'), params.id])
            redirect(action: "list")
            return
        }

        [placementOpportunitiesInstance: placementOpportunitiesInstance]
    }

    def update() {
        def placementOpportunitiesInstance = PlacementOpportunities.get(params.id)
        if (!placementOpportunitiesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'placementOpportunities.label', default: 'PlacementOpportunities'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (placementOpportunitiesInstance.version > version) {
                placementOpportunitiesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'placementOpportunities.label', default: 'PlacementOpportunities')] as Object[],
                          "Another user has updated this PlacementOpportunities while you were editing")
                render(view: "edit", model: [placementOpportunitiesInstance: placementOpportunitiesInstance])
                return
            }
        }

        placementOpportunitiesInstance.properties = params

        if (!placementOpportunitiesInstance.save(flush: true)) {
            render(view: "edit", model: [placementOpportunitiesInstance: placementOpportunitiesInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'placementOpportunities.label', default: 'PlacementOpportunities'), placementOpportunitiesInstance.id])
        redirect(action: "show", id: placementOpportunitiesInstance.id)
    }

    def delete() {
        def placementOpportunitiesInstance = PlacementOpportunities.get(params.id)
        if (!placementOpportunitiesInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'placementOpportunities.label', default: 'PlacementOpportunities'), params.id])
            redirect(action: "list")
            return
        }

        try {
            placementOpportunitiesInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'placementOpportunities.label', default: 'PlacementOpportunities'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'placementOpportunities.label', default: 'PlacementOpportunities'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
