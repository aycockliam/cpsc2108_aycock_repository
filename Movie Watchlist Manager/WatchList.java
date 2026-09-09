import java.util.ArrayList;


// Step 2
public class WatchList implements WatchListInterface{

    // Step 3
    private ArrayList<String> movies;

    // Step 4
    public WatchList(){
        this.movies = new ArrayList<>();

    }

    @Override
    public void addMovie(String title) {
        // Step 4
        movies.add(title);
    }

        @Override
    public String getMovie(int index) {
        // Step 5
        return movies.get(index);
    }

        @Override
    public int getSize() {
        // Step 6
        return movies.size();
    }

        @Override
    public void updateMovie(int index, String newTitle) {
        movies.set(index, newTitle);
    }

    @Override
    public boolean removeMovie(String title) {
        return movies.remove(title);
    }

    @Override
    public void printWatchlist() {
        for (int i=0; i < movies.size(); i++){
            System.out.println(i+":"+" "+ getMovie(i));
        }
    }

    // Optional Step
    @Override
    public boolean containsMovie(String title){
        return movies.contains(title);
    }

    
}
