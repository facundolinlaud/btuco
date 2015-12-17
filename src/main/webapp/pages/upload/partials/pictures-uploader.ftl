<#--
	<form enctype="multipart/form-data" action="/backoffice/upload" method="post">
-->

<form id="picturesForm" runat="server">
	<input type='file' name='pictures[]' class='pictures' multiple/>
	<input type='hidden' name='centers[]'/>
	<input type='submit'/>
</form>