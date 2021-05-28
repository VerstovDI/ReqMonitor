<#import "parts/common.ftlh" as c>
<#import "parts/prjsShow.ftlh" as r>

<@c.page>
    <div><h1>Projects page!</h1></div>
    <h4><a href="/projects/add">Add new project</a></h4>
    <h4>List projects: </h4>
    <@r.show/>

</@c.page>