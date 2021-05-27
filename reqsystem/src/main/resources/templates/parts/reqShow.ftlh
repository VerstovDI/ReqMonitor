<#macro show>
    <#setting time_format="hh::mm::SS"/>
    <form action="/main" method="get">
        <div class="form-group row">
            <div class="col-sm-6">
                <table border="1">
                    <tr>
                        <th>Title</th>
                        <th>Art type</th>
                        <th>Description</th>
                        <th>Limit time</th>
                        <th>Location </th>
                        <th>Origin</th>
                        <th>Creation date</th>

                    </tr>
                    <#list requirements! as requirement>
                        <tr>
                            <th>${requirement.title}</th>
                            <th>${requirement.artType}</th>
                            <th>${requirement.description}</th>
                            <th>${requirement.limitTime}</th>
                            <th>${requirement.loc}</th>
                            <th>${requirement.origin}</th>
                            <th>${requirement.date?datetime}</th>
                        </tr>
                    </#list>
                </table>
            </div>
        </div>



        <input type="submit" value="go to main page">

    </form>
</#macro>