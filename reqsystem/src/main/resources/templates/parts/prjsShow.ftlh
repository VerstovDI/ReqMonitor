<#macro show>
    <#setting time_format="hh::mm::SS"/>
    <form action="/projects/prjsShow" method="get">

        <div class="form-group row">
            <div class="col-sm-6">
                <table border="1">
                    <tr>
                        <th>Name</th>
                        <th>Founder</th>
                    </tr>
                    <#list projects as project>
                        <tr>
                            <th>${project.name}</th>
                            <th>${project.founder}</th>
                        </tr>
                    </#list>
                </table>
            </div>
        </div>

    </form>
</#macro>