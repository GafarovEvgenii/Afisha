package ru.netology;

public class MovieManager {


    Movie[] items = new Movie[0];


    public void download(Movie item) {

        int length = items.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        this.items = tmp;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }


    public Movie[] lastMovies(Movie amountMovies) {
        int limit = 0;
        limit = amountMovies.getAmountMovies();
        if (items.length > limit) {
            Movie[] result = new Movie[limit];
            for (int i = 0; i < result.length; i++) {
                int index = items.length - i - 1;
                result[i] = this.items[index];
            }
            return result;
        } else {
            Movie[] result = new Movie[items.length];
            for (int i = 0; i < result.length; i++) {
                int index = items.length - i - 1;
                result[i] = this.items[index];
            }
            return result;
        }
    }

    public Movie[] findAll() {
        return items;
    }
}
