<#import "parts/common.ftlh" as c>
<#import "parts/reqShow.ftlh" as s>
<!-- Главная страница сайта -->
<@c.page>
    <div><h1>Release page!</h1></div>
    <h5>Release version: ${release.version}</h5>
    <h5>Release description: ${release.description}</h5>
    <h5>Specification of release: <a href="/specs/showParticularSpec/${spec.id}">Show</a></h5>
    <h5><a href="/requirements/add/${release.id}">Add new requirement</a></h5>
    <h5>List release's requirements: </h5>
    <@s.show/>
</@c.page>