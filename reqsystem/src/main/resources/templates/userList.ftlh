<#import "parts/common.ftlh" as c>

<@c.page>
    Список пользователей
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Role</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list user as u>
            <tr>
                <td>${u.username}</td>
                <td><#list u.roles as role>${role}<#sep>,</#list></td>
                <td><a href="/user/${u.id}">edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>