import placement.Student
import placement.Application
import placement.Status
import placement.PlacementOpportunities

class BootStrap {

    def init = { servletContext ->
       def stujames = new Student(name:'James', coursecode:'G450', notes:'N/A', applications:'accepted').save();
       def stuchloe = new Student(name:'Chloe', coursecode:'G119', notes:'N/A', applications:'offered').save();
       def appjames = new Application(student:'James', placement:'GSK', status:'accepted', timestamp:'20:49').save();
       def appchloe = new Application(student:'Chloe', placement:'LLD', status:'offered', timestamp:'07:23').save();
       def stjames = new Status(code:'001', description:'accepted').save();
       def stchloe = new Status(code:'002', description:'offered').save();
       def placjames = new PlacementOpportunities(jobtitle:'IT technician', company:'GSK', name:'GSK', applications:'007', status:'open').save();
       def placchloe = new PlacementOpportunities(jobtitle:'first line analyst', company:'LLD', name:'LLD', applications:'011', status:'closed').save();
    }
    def destroy = {
    }
}
