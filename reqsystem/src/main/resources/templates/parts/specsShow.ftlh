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
                        <th>Project id</th>
                    </tr>
                    <#list specs as spec>
                        <tr>
                            <th>${spec.id}</th>
                            <th>${spec.version}</th>
                            <th>${spec.description}</th>
                            <th>${spec.project.id}</th>
                        </tr>
                    </#list>
                </table>
            </div>
        </div>

    </form>
</#macro>