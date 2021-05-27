<#import "parts/common.ftlh" as c>
<#import "parts/releasesShow.ftlh" as s>
<!-- Главная страница сайта -->
<@c.page>
    <div><h1>Specification page!</h1></div>
    <h5>Specification version: ${spec.version}</h5>
    <h5>Specification description: ${spec.description}</h5>
    <h5>Project of specification: <a href="/projects/showParticularProject/${project.id}">Show</a></h5>
    <h5><a href="/releases/add/${spec.id}">Add new release</a></h5>
    <h5>List specification's releases:</h5>
    <@s.show/>
</@c.page>