package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import org.example.entity.ContohEntity;
import org.example.service.ContohService;
import org.springframework.stereotype.Service;
import java.io.InputStream;
import java.util.HashMap;

@Slf4j
@Service
public class ContohServiceImpl implements ContohService {


    @Override
    public ContohEntity generateLaporan(String filename) throws JRException {

        HashMap<String, Object> data = new HashMap<>();
        data.put("id","1");
        data.put("nama","Nemo");
        data.put("nama_film","Haikyuu The Movie: Battle of Concept");
        data.put("harga","Rp30.000,00");
        data.put("studio","Studio 1");
        data.put("kursi","D-5");
        data.put("jadwal","28/10/2022 , Pukul 10.00 WIB");
        InputStream reportStream = getClass().getResourceAsStream("/Laporan.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, data);
        byte[] file = JasperExportManager.exportReportToPdf(jasperPrint);
        ContohEntity database = new ContohEntity();
        database.setData(file);
        database.setNamaFile(filename);
        database.setTipeDataFile("application/pdf");
        return database;
    }
}