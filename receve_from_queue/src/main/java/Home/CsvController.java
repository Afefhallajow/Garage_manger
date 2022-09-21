package Home;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
// Export to CSv file
@RestController
public class CsvController {

private     ICsvBeanWriter csvBean;


@Autowired
appService appService;

    public ICsvBeanWriter getCsvBean() {
        return csvBean;
    }

    public void setCsvBean(ICsvBeanWriter csvBean) {
        this.csvBean = csvBean;
    }

    public Home.appService getAppService() {
        return appService;
    }

    public void setAppService(Home.appService appService) {
        this.appService = appService;
    }

    @GetMapping("/user")
    public void exportToCSV(HttpServletResponse response) throws IOException {
       try {


           response.setContentType("text/csv");

           String headerKey = "Con tent-Disposition";
           String headerValue = "attachment; filename=cars_" + ".csv";
           response.setHeader(headerKey, headerValue);

         List<cars>  carsList = new ArrayList<>();
carsList=appService.FindBydate();
           ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
           String[] csvHeader = {"id", "Name", "Date"};
           String[] nameMapping = {"id", "name", "date"};

           csvWriter.writeHeader(csvHeader);

           for (cars car : carsList) {
               csvWriter.write(car, nameMapping);
           }



this.csvBean=csvWriter;



           csvWriter.close();

       }
       catch (Exception e) {
           System.out.println("faild");
       }
       }
public void print()
{
  System.out.println(  csvBean.getLineNumber());
}
}