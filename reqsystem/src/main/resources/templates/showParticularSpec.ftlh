<#import "parts/common.ftlh" as c>
<#import "parts/releasesShow.ftlh" as s>
<!-- Главная страница сайта -->
<@c.page>
    <div><h1>Hello from show specification page!</h1></div>
    <h3>Specification version: ${spec.version}</h3>
    <br/>
    <h3>Specification description: ${spec.description}</h3>
    <@s.show/>
</@c.page>