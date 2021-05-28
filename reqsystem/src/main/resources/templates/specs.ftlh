<#import "parts/common.ftlh" as c>
<#import "parts/specsShow.ftlh" as r>

<!-- Главная страница сайта -->
<@c.page>
    <div><h1>Specifications page</h1></div>
    <h4>List specifications: </h4>
    <@r.show/>
</@c.page>