<%@ include file="/WEB-INF/backbase.com.launchpad/common/directives.jspf" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <title>{{title}}</title>
        <link rel="stylesheet" href="${contextPath}/static/backbase.com.launchpad/containers/{{dashed}}/{{dashed}}.css"/>
        <script src="${contextPath}/static/backbase.com.launchpad/containers/{{dashed}}/{{dashed}}.js"/>
    </head>
    <body>
        <c:catch var="exception">

            <b:areaSort src="${item}" />
            <div data-pid="${item.name}" class="bp-container bp-{{dashed}}">
                <div class="bp-area">
                    <c:forEach items="${item.children}" var="child">
                        <b:include src="${child}"/>
                    </c:forEach>
                </div>
                <div class="clear"></div>
            </div>
        </c:catch>
        <c:if test="${not empty e}">
            <div class="bp-container">
                <p>Sorry, there was an error rendering container {{title}} (${e.message})</p>
            </div>
        </c:if> 
    </body>
</html>