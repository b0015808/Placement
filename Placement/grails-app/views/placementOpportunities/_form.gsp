<%@ page import="placement.PlacementOpportunities" %>



<div class="fieldcontain ${hasErrors(bean: placementOpportunitiesInstance, field: 'applications', 'error')} ">
	<label for="applications">
		<g:message code="placementOpportunities.applications.label" default="Applications" />
		
	</label>
	<g:textField name="applications" value="${placementOpportunitiesInstance?.applications}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: placementOpportunitiesInstance, field: 'company', 'error')} ">
	<label for="company">
		<g:message code="placementOpportunities.company.label" default="Company" />
		
	</label>
	<g:textField name="company" value="${placementOpportunitiesInstance?.company}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: placementOpportunitiesInstance, field: 'job_title', 'error')} ">
	<label for="job_title">
		<g:message code="placementOpportunities.job_title.label" default="Jobtitle" />
		
	</label>
	<g:textField name="job_title" value="${placementOpportunitiesInstance?.job_title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: placementOpportunitiesInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="placementOpportunities.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${placementOpportunitiesInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: placementOpportunitiesInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="placementOpportunities.status.label" default="Status" />
		
	</label>
	<g:textField name="status" value="${placementOpportunitiesInstance?.status}"/>
</div>

