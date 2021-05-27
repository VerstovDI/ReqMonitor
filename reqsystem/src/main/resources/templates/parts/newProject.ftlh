<#macro add>
    <#setting time_format="hh::mm::SS"/>
    <form action="/projects/addProject" method="get">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Name of project:</label>
            <div class="col-sm-6">
                <input type="text" name="prjName"
                       class="form-control ${(titleError??)?string('is-invalid','')}"
                       placeholder="Name"/>
                <#if prjNameError??>
                    <div class="invalid-feedback">
                        ${prjNameError}
                    </div>
                </#if>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Founder:</label>
            <div class="col-sm-6">
                <input type="text" name="founder"
                       class="form-control ${(artTypeError??)?string('is-invalid','')}"
                       placeholder="Founder"/>
                <#if artTypeError??>
                    <div class="invalid-feedback">
                        ${founder}
                    </div>
                </#if>
            </div>
        </div>

        <input type="submit" value="Submit">

    </form>
</#macro>