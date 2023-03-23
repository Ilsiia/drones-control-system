package ilsia.sabirzianova.dcs.services;

import ilsia.sabirzianova.dcs.exceptions.IllegalDataException;
import ilsia.sabirzianova.dcs.model.Medication;
import ilsia.sabirzianova.dcs.model.jpa.entity.MedicationEntity;
import ilsia.sabirzianova.dcs.model.jpa.repository.MedicationCrudRepository;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Service
public class MedicationServiceImpl implements MedicationService {
    Logger logger = LoggerFactory.getLogger(MedicationServiceImpl.class);

    @Autowired
    MedicationCrudRepository repository;

    @Override
    public void register(Medication medication) throws IllegalDataException {
        repository.save(createEntity(medication));
    }

    private MedicationEntity createEntity(Medication medication) throws IllegalDataException {
        return new MedicationEntity(medication.getName(), medication.getWeight(), medication.getCode(), medication.getImage());
    }

    @PostConstruct
    private void fillData() {
        if (!repository.findAll().iterator().hasNext()) {
            try {
                InputStream file_1 = new ClassPathResource("images/nurofen.png").getInputStream();
                InputStream file_2 = new ClassPathResource("images/polisorb.png").getInputStream();
                InputStream file_3 = new ClassPathResource("images/tamiflu.png").getInputStream();
                InputStream file_4 = new ClassPathResource("images/zodak.png").getInputStream();
                byte[] data_1 = IOUtils.toByteArray(file_1);
                byte[] data_2 = IOUtils.toByteArray(file_2);
                byte[] data_3 = IOUtils.toByteArray(file_3);
                byte[] data_4 = IOUtils.toByteArray(file_4);
                register(new Medication("nurofen", 100, "CODE_1", data_1));
                register(new Medication("polisorb", 300, "CODE_2", data_2));
                register(new Medication("tamiflu", 30, "CODE_3", data_3));
                register(new Medication("zodak", 60, "CODE_4", data_4));
            } catch (IOException | IllegalDataException e) {
                logger.error(e.getMessage(), e);
            } finally {
                logger.info("MEDICATION is filled.");
            }
        }
    }
}
