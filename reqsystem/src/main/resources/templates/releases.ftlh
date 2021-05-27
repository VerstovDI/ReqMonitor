<#import "parts/common.ftlh" as c>
<#import "parts/releasesShow.ftlh" as r>

<!-- Главная страница сайта -->
<@c.page>
    <div><h1>Releases page!</h1></div>
    <br/>
    <h4>List releases: </h4>
    <@r.show/>
</@c.page>