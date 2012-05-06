package placement



import org.junit.*
import grails.test.mixin.*

@TestFor(PlacementOpportunitiesController)
@Mock(PlacementOpportunities)
class PlacementOpportunitiesControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/placementOpportunities/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.placementOpportunitiesInstanceList.size() == 0
        assert model.placementOpportunitiesInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.placementOpportunitiesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.placementOpportunitiesInstance != null
        assert view == '/placementOpportunities/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/placementOpportunities/show/1'
        assert controller.flash.message != null
        assert PlacementOpportunities.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/placementOpportunities/list'


        populateValidParams(params)
        def placementOpportunities = new PlacementOpportunities(params)

        assert placementOpportunities.save() != null

        params.id = placementOpportunities.id

        def model = controller.show()

        assert model.placementOpportunitiesInstance == placementOpportunities
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/placementOpportunities/list'


        populateValidParams(params)
        def placementOpportunities = new PlacementOpportunities(params)

        assert placementOpportunities.save() != null

        params.id = placementOpportunities.id

        def model = controller.edit()

        assert model.placementOpportunitiesInstance == placementOpportunities
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/placementOpportunities/list'

        response.reset()


        populateValidParams(params)
        def placementOpportunities = new PlacementOpportunities(params)

        assert placementOpportunities.save() != null

        // test invalid parameters in update
        params.id = placementOpportunities.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/placementOpportunities/edit"
        assert model.placementOpportunitiesInstance != null

        placementOpportunities.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/placementOpportunities/show/$placementOpportunities.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        placementOpportunities.clearErrors()

        populateValidParams(params)
        params.id = placementOpportunities.id
        params.version = -1
        controller.update()

        assert view == "/placementOpportunities/edit"
        assert model.placementOpportunitiesInstance != null
        assert model.placementOpportunitiesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/placementOpportunities/list'

        response.reset()

        populateValidParams(params)
        def placementOpportunities = new PlacementOpportunities(params)

        assert placementOpportunities.save() != null
        assert PlacementOpportunities.count() == 1

        params.id = placementOpportunities.id

        controller.delete()

        assert PlacementOpportunities.count() == 0
        assert PlacementOpportunities.get(placementOpportunities.id) == null
        assert response.redirectedUrl == '/placementOpportunities/list'
    }
}
