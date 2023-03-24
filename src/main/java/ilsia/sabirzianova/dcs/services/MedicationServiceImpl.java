package ilsia.sabirzianova.dcs.services;

import ilsia.sabirzianova.dcs.model.Medication;
import ilsia.sabirzianova.dcs.model.jpa.entity.LobContainer;
import ilsia.sabirzianova.dcs.model.jpa.entity.MedicationEntity;
import ilsia.sabirzianova.dcs.model.jpa.repository.MedicationCrudRepository;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.io.InputStream;

@Service
public class MedicationServiceImpl implements MedicationService {
    Logger logger = LoggerFactory.getLogger(MedicationServiceImpl.class);
    @Autowired
    MedicationCrudRepository repository;

    @Override
    public void register(MedicationEntity medication) {
        repository.save(medication);
    }

    @Override
    public MedicationEntity findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public Medication convert(@NotNull MedicationEntity entity) {
        return new Medication(entity.getName(),entity.getWeight(),entity.getCode(), null);
    }

    private MedicationEntity createEntity(MedicationEntity medication) {
        return new MedicationEntity(medication.getName(), medication.getWeight(), medication.getCode(), medication.getLob());
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
                register(new MedicationEntity("nurofen", 100, "CODE_1", new LobContainer(data_1)));
                register(new MedicationEntity("polisorb", 300, "CODE_2", new LobContainer(data_2)));
                register(new MedicationEntity("tamiflu", 30, "CODE_3", new LobContainer(data_3)));
                register(new MedicationEntity("zodak", 60, "CODE_4", new LobContainer(data_4)));
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            } finally {
                logger.info("MEDICATION is filled.");
            }
        }
    }
}
