package apps

import grails.plugin.springsecurity.annotation.Secured
import com.jameskleeh.excel.ExcelBuilder

@Secured('ROLE_ADMIN')
class SecurityInfoController extends grails.plugin.springsecurity.ui.SecurityInfoController {
}
