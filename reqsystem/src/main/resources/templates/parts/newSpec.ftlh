<#macro add>

    <#setting time_format="hh::mm::SS"/>

    <form action="/specs/addSpec" method="get">

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Version of specification:</label>
            <div class="col-sm-6">
                <input type="number" name="version"
                       class="form-control ${(titleError??)?string('is-invalid','')}"
                       placeholder="Version"/>
                <#if prjNameError??>
                    <div class="invalid-feedback">
                        ${versionError}
                    </div>
                </#if>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Description:</label>
            <div class="col-sm-6">
                <input type="text" name="description"
                       class="form-control ${(artTypeError??)?string('is-invalid','')}"
                       placeholder="Description"/>
                <#if artTypeError??>
                    <div class="invalid-feedback">
                        ${descriptionError}
                    </div>
                </#if>
            </div>
        </div>

        <input type="submit" value="Submit">

    </form>
</#macro>