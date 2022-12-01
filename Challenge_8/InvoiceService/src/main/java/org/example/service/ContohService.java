package org.example.service;

import com.lo jmhwagie.text.DocumentException;
import net.sf.jasperreports.engine.JRException;
import org.example.entity.ContohEntity;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
@Service
public interface ContohService {
    ContohEntity generateLaporan(String filename) throws JRException, DocumentException, FileNotFoundException;
}
