<%@ page import="placement.Placement_Opportunity" %>



<div class="fieldcontain ${hasErrors(bean: placement_OpportunityInstance, field: 'applications', 'error')} ">
	<label for="applications">
		<g:message code="placement_Opportunity.applications.label" default="Applications" />
		
	</label>
	<g:textField name="applications" value="${placement_OpportunityInstance?.applications}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: placement_OpportunityInstance, field: 'company', 'error')} ">
	<label for="company">
		<g:message code="placement_Opportunity.company.label" default="Company" />
		
	</label>
	<g:textField name="company" value="${placement_OpportunityInstance?.company}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: placement_OpportunityInstance, field: 'job_title', 'error')} ">
	<label for="job_title">
		<g:message code="placement_Opportunity.job_title.label" default="Jobtitle" />
		
	</label>
	<g:textField name="job_title" value="${placement_OpportunityInstance?.job_title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: placement_OpportunityInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="placement_Opportunity.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${placement_OpportunityInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: placement_OpportunityInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="placement_Opportunity.status.label" default="Status" />
		
	</label>
	<g:textField name="status" value="${placement_OpportunityInstance?.status}"/>
</div>

