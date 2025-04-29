package br.edu.insper.insperclicker.repository;

import br.edu.insper.insperclicker.dto.PlayerDataDTO;
import br.edu.insper.insperclicker.repository.models.PlayerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;

public interface PlayerRepository extends MongoRepository<PlayerModel, String>
{
    PlayerModel findByName(String name);

    <T> Collection<T> findByName(String name, Class<T> type);

    List<PlayerDataDTO> findAllProjectedBy();
}
