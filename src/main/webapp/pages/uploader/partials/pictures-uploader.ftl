<#--
	<form enctype="multipart/form-data" action="/backoffice/upload" method="post">
-->

<form id="picturesForm" runat="server">
	<input type='file' name='pictures[]' class='pictures' multiple/>
	<input type='text' name='metadata'/>
	<input type='submit'/>
</form>