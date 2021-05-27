<#macro show>
    <#setting time_format="hh::mm::SS"/>
    <form method="get">

        <div class="form-group row">
            <div class="col-sm-6">
                <table border="1">
                    <tr>
                        <th>Name</th>
                        <th>Founder</th>
                        <th>Actions</th>
                    </tr>
                    <#list projects as project>
                        <tr>
                            <th>${project.name}</th>
                            <th>${project.founder}</th>
                            <th><a href="/projects/showParticularProject/${project.id}">Show</a></th>
                        </tr>
                    </#list>
                </table>
            </div>
        </div>

    </form>
</#macro>