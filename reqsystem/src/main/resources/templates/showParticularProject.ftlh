<#import "parts/common.ftlh" as c>
<#import "parts/specsShow.ftlh" as s>
<!-- Главная страница сайта -->
<@c.page>
    <div><h1>Project page!</h1></div>
    <h5>Project name: ${project.name}</h5>
    <h5>Project founder: ${project.founder}</h5>
    <h5><a href="/specs/add/${project.id}">Add new specification</a></h5>
    <h5>List project's specifications: </h5>
    <@s.show/>
</@c.page>