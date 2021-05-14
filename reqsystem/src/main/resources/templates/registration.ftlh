<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<!-- Страница регистрации -->
<@c.page>
<div class="mb-1">Add new user</div>
${message!""}
<@l.login "/registration" true />
</@c.page>