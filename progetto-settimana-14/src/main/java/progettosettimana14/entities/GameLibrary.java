package progettosettimana14.entities;

import progettosettimana14.exceptions.DuplicatedGameKeyException;
import progettosettimana14.exceptions.GameNotFoundException;

import java.util.HashSet;
import java.util.List;

public class GameLibrary {
    private HashSet<Game> library;

    public GameLibrary() {
        setLibrary(new HashSet<Game>());
    }

    public void add (Game game) throws DuplicatedGameKeyException {

        if(library.stream().anyMatch(libraryGame -> libraryGame.getId() == game.getId()))
            throw new DuplicatedGameKeyException();

        this.library.add(game);
    }

    public Game searchByID (int idToSearch) throws GameNotFoundException {

//        CODICE GENERATO DA ME
//        if(library.stream().noneMatch(libraryGame -> libraryGame.getId() == idToSearch))
//            throw new GameNotFoundException();
//
//        return library.stream().filter(libraryGame -> libraryGame.getId() == idToSearch).toList().getFirst();

//      CODICE GENERATO DOPO UNA RICERCA SU INTERNET E AIUTO DI INTELLIJ
        return library.stream()
                .filter(libraryGame -> libraryGame.getId() == idToSearch)
                .findFirst()
                .orElseThrow(GameNotFoundException::new)
        ;
    }

    public List<Game> searchByPrice (double maxPrice) throws GameNotFoundException {

        List<Game> res = library.stream()
                            .filter(game -> game.getPrice() < maxPrice)
                            .toList()
        ;

        if (res.isEmpty()) throw new GameNotFoundException();

        return res;
    }

    public List<Game> searchByNumberOfPlayer(int maxPlayer) throws GameNotFoundException {

        List<Game> res = library.stream()
                            .filter(game ->
                                    game instanceof TableGame
                                    &&
                                    ((TableGame) game).getNumberOfPlayer() <= maxPlayer
                            )
                            .toList()
        ;

        if (res.isEmpty()) throw new GameNotFoundException();

        return res;

    }

    public int removeID (int idToRemove) throws GameNotFoundException {

//        CODICE GENERATO DA ME
//        if(library.stream().noneMatch(game -> game.getId() == idToRemove))
//            throw new GameNotFoundException();

//        library = (HashSet<Game>) library.stream().filter(game -> game.getId() != idToRemove).collect(Collectors.toSet());

//      CODICE POST RICERCA SU INTERNET
        if(!library.removeIf(game -> game.getId() == idToRemove))
            throw new GameNotFoundException();

        return idToRemove;
    }

    public void updateByID (int idToUpdate, Game newData) throws GameNotFoundException {
        removeID(idToUpdate);

        if (newData.getId() != idToUpdate)
            newData.updateID(idToUpdate);

        library.add(newData);
    }

    public HashSet<Game> getLibrary() {
        return library;
    }

    public void setLibrary(HashSet<Game> library) {
        this.library = library;
    }

    public LibraryGeneralStatistics statistics (){
        return new LibraryGeneralStatistics(this.library);
    }

    @Override
    public String toString() {
        return "GameLibrary{" +
                "\n\tlibrary=\n\t" + library +
                "\n}";
    }
}

