<#macro show>
    <#setting time_format="hh::mm::SS"/>
    <form method="get">

        <div class="form-group row">
            <div class="col-sm-6">
                <table border="1">
                    <tr>
                        <th>id</th>
                        <th>Version</th>
                        <th>Description</th>
                        <th>Specification id</th>
                    </tr>
                    <#list releases as release>
                        <tr>
                            <th>${release.id}</th>
                            <th>${release.version}</th>
                            <th>${release.description}</th>
                            <th>${release.specification.id}</th>
                        </tr>
                    </#list>
                </table>
            </div>
        </div>

    </form>
</#macro>