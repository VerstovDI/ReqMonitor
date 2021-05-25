<#macro add>
    <#setting time_format="hh::mm::SS"/>
    <form action="/requirements/addReq" method="get">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Title:</label>
            <div class="col-sm-6">
                <input type="text" name="title"
                       class="form-control ${(titleError??)?string('is-invalid','')}"
                       placeholder="Title"/>
                <#if titleError??>
                    <div class="invalid-feedback">
                        ${titleError}
                    </div>
                </#if>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Art type:</label>
            <div class="col-sm-6">
                <input type="text" name="artType"
                       class="form-control ${(artTypeError??)?string('is-invalid','')}"
                       placeholder="Art type"/>
                <#if artTypeError??>
                    <div class="invalid-feedback">
                        ${artTypeError}
                    </div>
                </#if>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Description:</label>
            <div class="col-sm-6">
                <input type="text" name="description"
                       class="form-control ${(descriptionError??)?string('is-invalid','')}"
                       placeholder="Description"/>
                <#if descriptionError??>
                    <div class="invalid-feedback">
                        ${descriptionError}
                    </div>
                </#if>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Loc:</label>
            <div class="col-sm-6">
                <input type="text" name="loc"
                       class="form-control ${(locError??)?string('is-invalid','')}"
                       placeholder="Loc"/>
                <#if locError??>
                    <div class="invalid-feedback">
                        ${locError}
                    </div>
                </#if>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Origin:</label>
            <div class="col-sm-6">
                <input type="text" name="origin"
                       class="form-control ${(originError??)?string('is-invalid','')}"
                       placeholder="Origin"/>
                <#if originError??>
                    <div class="invalid-feedback">
                        ${originError}
                    </div>
                </#if>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Limit time:</label>
            <div class="col-sm-6">
                <input type="time" name="limitTime"
                       class="form-control ${(limitTimeError??)?string('is-invalid','')}"
                       placeholder="Limit time"/>
                <#if limitTimeError??>
                    <div class="invalid-feedback">
                        ${limitTimeError}
                    </div>
                </#if>
            </div>
        </div>


        <div>
            <h7>release: version, description, specification.version, specification.description</h7>
        </div>
        <div class="form-group row">
            <select class="custom-select col-md-12-sm-6" name="selectedRelease">
                <#list releases! as release>
                    <option value="${release.id}">${release.version}, ${release.description}
                        , ${release.specification.version}, ${release.specification.description}</option>
                </#list>
            </select>
        </div>



        <input type="submit" value="Submit">

    </form>
</#macro>