<#macro show>
    <#setting time_format="hh::mm::SS"/>
    <form method="get">

        <div class="form-group row">
            <div class="col-sm-6">
                <table border="1">
                    <tr>
                        <th>Version</th>
                        <th>Description</th>
                        <th>Actions</th>
                    </tr>
                    <#list releases as release>
                        <tr>
                            <th>${release.version}</th>
                            <th>${release.description}</th>
                            <th><a href="/releases/showParticularRelease/${release.id}">Show</a></th>
                        </tr>
                    </#list>
                </table>
            </div>
        </div>

    </form>
</#macro>