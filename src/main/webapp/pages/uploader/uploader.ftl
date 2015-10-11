<#import "/commons/macros.ftl" as macros>

<#assign head>
	<#include "/uploader/partials/uploader-scripts.ftl">
</#assign>

<@macros.frame head>
	<#include "/uploader/partials/pictures-uploader.ftl">
	
	<div class="picture-coordinator"></div>
</@macros.frame>