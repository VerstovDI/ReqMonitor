<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/"><b>ReqSystem</b></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/main">Messages</a>
            </li>
            <#if user??>
                <li class="nav-item">
                    <a class="nav-link" href="/user-messages/${currentUserId}">My messages</a>
                </li>
            </#if>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user">User list</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin-monitor">Admin monitor</a>
                </li>
            </#if>
            <#if user?? && name!="unknown" && name != "Guest">
                <li class="nav-item">
                    <a class="nav-link" href="/user/profile">Profile</a>
                </li>
            </#if>
            <#if user?? && name!="unknown" && name != "Guest">
                <li class="nav-item">
                    <a class="nav-link" href="/requirements">Requirements</a>
                </li>
            </#if>
        </ul>
        <div class="navbar-text mr-3">
            <#if user??>
                ${name}
            <#else>
                Guest
            </#if>
        </div>
        <#if user??>
            <@l.logout/>
        <#else>
            <a href="http://localhost:8080/login" class="btn btn-primary" role="button" aria-pressed="true">
                Sign In/Sign up
            </a>
        </#if>
    </div>
</nav>