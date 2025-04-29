package br.edu.insper.insperclicker.game.common;

import br.edu.insper.insperclicker.dto.PlayerDataDTO;
import br.edu.insper.insperclicker.exception.IncorrectPasswordException;
import br.edu.insper.insperclicker.repository.PlayerRepository;
import br.edu.insper.insperclicker.repository.models.PlayerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PlayerState
{
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PlayerRepository repository;

    public PlayerModel getPlayerInstance(String name, String password) throws IncorrectPasswordException
    {
        PlayerModel playerModel = repository.findByName(name);
        if(playerModel == null)
        {
            playerModel = repository.save(
                    PlayerModel.from(
                            new Player(name, passwordEncoder.encode(password)
                            )));
        }
        else
        {
            if(!passwordEncoder.matches(password, playerModel.password()))
                throw new IncorrectPasswordException(name, password);
        }
        return playerModel;
    }

    public Collection<PlayerDataDTO> findPlayerByName(String name)
    {
        return repository.findByName(name, PlayerDataDTO.class);
    }

    public List<PlayerDataDTO> listPlayers()
    {
        return repository.findAllProjectedBy();
    }

    public PlayerModel saveState(PlayerModel player)
    {
        return repository.save(player);
    }

    public Game getGameInstance(String playerName, String password) throws IncorrectPasswordException
    {
        return PlayerModel.to(getPlayerInstance(playerName, password)).getGame();
    }

}
