package hr.aom.aomoruzarstvoapp.service;

import hr.aom.aomoruzarstvoapp.model.Oprema;
import hr.aom.aomoruzarstvoapp.model.Posudba;
import hr.aom.aomoruzarstvoapp.model.Zaduzenje;
import hr.aom.aomoruzarstvoapp.repository.OpremaRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OpremaService implements IOpremaService{

    @Autowired
    private OpremaRepository repository;
    @Autowired
    private OsobaService osobaService;
    @Autowired
    private PosudbaService posudbaService;

    @Override
    public void spremiZaduzenja(Zaduzenje zaduzenje) throws ParseException {
        Optional<String> username = osobaService.dohvatiUsernamePrekoImePrezime(zaduzenje.getUsername());
        if(username.isEmpty()) {
            System.err.printf("Username za osobu %s nije poznat\n", zaduzenje.getUsername());
            return;
        }

        for(String komadOpreme : zaduzenje.getOpremaC())
            posudbaService.save(new Posudba(
                    username.get(),
                    komadOpreme,
                    new SimpleDateFormat("yyyy-MM-dd").parse(zaduzenje.getDatumPovrata()),
                    zaduzenje.getKolicina())
            );
    }

    @Override
    public List<Oprema> findAll() {
        return (List<Oprema>) repository.findAll();
    }

    @Override
    public boolean spremiOpremuIzExcela(InputStream is) {
        List<Posudba> posudbe = posudbaService.findAll();
        posudbaService.deleteAll();

        repository.deleteAll();

        Workbook workbook;
        try {
            workbook = new XSSFWorkbook(is);
        } catch (IOException e) {
            return false;
        }

        Sheet sheet = workbook.getSheet("Inventura");
        for(Row row : sheet) {
            if(row.getRowNum() == 0) continue;
            if(row.getCell(0) == null) continue;
            Oprema oprema = new Oprema(
                    row.getCell(0).getStringCellValue(),
                    row.getCell(1) != null ? row.getCell(1).getStringCellValue() : null,
                    row.getCell(2) != null ? row.getCell(2).getStringCellValue() : null,
                    row.getCell(3).getStringCellValue(),
                    row.getCell(4) != null ? row.getCell(4).getStringCellValue() : null,
                    row.getCell(5) != null ? row.getCell(5).getStringCellValue() : null,
                    (int)Math.round(row.getCell(6).getNumericCellValue()),
                    row.getCell(7) != null ? (int)Math.round(row.getCell(7).getNumericCellValue()) : null,
                    row.getCell(8).getCellType() == Cell.CELL_TYPE_NUMERIC ? (int)Math.round(row.getCell(7).getNumericCellValue()) : null,
                    row.getCell(10) != null ? row.getCell(10).getStringCellValue() : null
            );
            repository.save(oprema);
        }

        posudbaService.saveALl(posudbe);
        return true;
    }

}
