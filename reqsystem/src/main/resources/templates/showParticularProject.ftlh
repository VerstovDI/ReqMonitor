<#import "parts/common.ftlh" as c>
<#import "parts/specsShow.ftlh" as s>
<!-- Главная страница сайта -->
<@c.page>
    <div><h1>Hello from show project page!</h1></div>
    <h3>Project name: ${project.name}</h3>
    <br/>
    <h3>Project founder: ${project.founder}</h3>
    <@s.show/>
</@c.page>