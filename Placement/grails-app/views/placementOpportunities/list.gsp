
<%@ page import="placement.PlacementOpportunities" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'placementOpportunities.label', default: 'PlacementOpportunities')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-placementOpportunities" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-placementOpportunities" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="applications" title="${message(code: 'placementOpportunities.applications.label', default: 'Applications')}" />
					
						<g:sortableColumn property="company" title="${message(code: 'placementOpportunities.company.label', default: 'Company')}" />
					
						<g:sortableColumn property="job_title" title="${message(code: 'placementOpportunities.job_title.label', default: 'Jobtitle')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'placementOpportunities.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="status" title="${message(code: 'placementOpportunities.status.label', default: 'Status')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${placementOpportunitiesInstanceList}" status="i" var="placementOpportunitiesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${placementOpportunitiesInstance.id}">${fieldValue(bean: placementOpportunitiesInstance, field: "applications")}</g:link></td>
					
						<td>${fieldValue(bean: placementOpportunitiesInstance, field: "company")}</td>
					
						<td>${fieldValue(bean: placementOpportunitiesInstance, field: "job_title")}</td>
					
						<td>${fieldValue(bean: placementOpportunitiesInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: placementOpportunitiesInstance, field: "status")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${placementOpportunitiesInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
