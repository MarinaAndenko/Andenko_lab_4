<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@page contentType="text/html"%>

<t:genericpage>
	<jsp:attribute name="header">
        Edit Worker
    </jsp:attribute>
	<jsp:body>
        <form action="edit" name="form" method="POST"
			novalidate="novalidate">
            <div class="form-horizontal">
                <h4>Форма отправки</h4>
                <hr>
				<input name="id" type="hidden" value="${worker.id }">

                <div class="form-group">
                    <label class="control-label col-md-2" for="name">Name</label>
                    <div class="col-md-10">
                        <input
							class="col-md-1 form-control text-box single-line valid"
							data-val="true"
							data-val-length="The field Name must be a string with a maximum length of 50."
							data-val-length-max="50"
							data-val-required="Required." id="name" name="name"
							type="text" value="${worker.name}">
                        <span
							class="col-md-offset-1 text-danger field-validation-valid"
							data-valmsg-for="name" data-valmsg-replace="true">
                            <span for="name" class=""></span>
                        </span>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-2" for="position">Position</label>
                    <div class="col-md-10">
                        <input
                                class="col-md-1 form-control text-box single-line valid"
                                data-val="true"
                                data-val-length="The field Position must be a string with a maximum length of 50."
                                data-val-length-max="50"
                                data-val-required="Required." id="position" name="position"
                                type="text" value="${worker.position}">
                        <span
                                class="col-md-offset-1 text-danger field-validation-valid"
                                data-valmsg-for="position" data-valmsg-replace="true">
                            <span for="position" class=""></span>
                        </span>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-2" for="department">Department</label>
                    <div class="col-md-10">
                        <input
                                class="col-md-1 form-control text-box single-line valid"
                                data-val="true"
                                data-val-length="The field Department must be a string with a maximum length of 50."
                                data-val-length-max="50"
                                data-val-required="Required." id="department" name="department"
                                type="text" value="${worker.department}">
                        <span
                                class="col-md-offset-1 text-danger field-validation-valid"
                                data-valmsg-for="department" data-valmsg-replace="true">
                            <span for="department" class=""></span>
                        </span>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-2" for="start">Start Holiday Date</label>
                    <div class="col-md-10">
                        <input
                                class="col-md-1 form-control text-box single-line valid"
                                data-val="true"
                                data-val-length="The field Start must be a string with a maximum length of 50."
                                data-val-length-max="50"
                                data-val-required="Required." id="start" name="start"
                                type="date" value="${worker.startHoliday}">
                        <span
                                class="col-md-offset-1 text-danger field-validation-valid"
                                data-valmsg-for="start" data-valmsg-replace="true">
                            <span for="start" class=""></span>
                        </span>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-2" for="end">End Holiday Date</label>
                    <div class="col-md-10">
                        <input
                                class="col-md-1 form-control text-box single-line valid"
                                data-val="true"
                                data-val-length="The field End must be a string with a maximum length of 50."
                                data-val-length-max="50"
                                data-val-required="Required." id="end" name="end"
                                type="date" value="${worker.endHoliday}">
                        <span
                                class="col-md-offset-1 text-danger field-validation-valid"
                                data-valmsg-for="end" data-valmsg-replace="true">
                            <span for="end" class=""></span>
                        </span>
                    </div>
                </div>

                <div class="form-group">
                    <div
						class="col-xs-offset-1 col-md-offset-2 col-xs-2">
                        <input type="submit" value="Submit"
							class="btn btn-default">
                    </div>

                    <div class="col-xs-2">
                        <input type="reset" value="Clear"
							class="btn btn-default">
                    </div>
                </div>
            </div>
        </form>
    </jsp:body>
</t:genericpage>