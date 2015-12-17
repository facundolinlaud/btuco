<#import "/commons/macros.ftl" as macros>

<#assign head>
	<#include "/upload/partials/upload-scripts.ftl">
</#assign>

<@macros.frame head>
	<#include "/upload/partials/pictures-uploader.ftl">
	
	<div class="picture-coordinator"></div>
</@macros.frame>