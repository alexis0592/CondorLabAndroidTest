package co.com.yacalder.condormovies.ui.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import co.com.yacalder.condormovies.R;
import co.com.yacalder.condormovies.data.entity.PopularMovie.Movie;
import co.com.yacalder.condormovies.data.entity.PopularMovie.Result;
import co.com.yacalder.condormovies.view.MovieAdapterView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Movie movie;
    private MovieAdapterView movieAdapterViewListener;

    public MovieAdapter(Movie movie, MovieAdapterView listener) {
        this.movie = movie;
        this.movieAdapterViewListener = listener;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        MovieViewHolder movieViewHolder = new MovieViewHolder(view, this.movieAdapterViewListener);

        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder movieViewHolder, int position) {

        movieViewHolder.setMovie(movie, position);
        movieViewHolder.titleTextView.setText(movie.getResults().get(position).getOriginalTitle());
        movieViewHolder.voteAverageTextView.setText(movie.getResults().get(position).getVoteAverage().toString());
        Uri uri = Uri.parse("https://image.tmdb.org/t/p/w500" +
                                                movie.getResults().get(position).getPosterPath());
        movieViewHolder.movieImageView.setImageURI(uri);

    }

    @Override
    public int getItemCount() {
        return movie.getResults().size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
            {

        private CardView cardView;
        private TextView titleTextView;
        private TextView voteAverageTextView;
        private SimpleDraweeView movieImageView;
        private Movie movie;
        private int position;
        private MovieAdapterView movieAdapterView;

        public MovieViewHolder(View itemView, MovieAdapterView movieAdapterView) {
            super(itemView);
            this.movieAdapterView = movieAdapterView;
            itemView.setOnClickListener(this);
            cardView = itemView.findViewById(R.id.cv);
            titleTextView = itemView.findViewById(R.id.movie_name);
            voteAverageTextView = itemView.findViewById(R.id.vote_average);
            movieImageView = itemView.findViewById(R.id.movie_picture);

        }

        public Movie getMovie() {
            return movie;
        }

        public void setMovie(Movie movie, int pos) {
            this.movie = movie;
            this.position = pos;
        }

        @Override
        public void onClick(View view) {
            this.movieAdapterView.onMovieSelected(getMovie().getResults().get(position));

        }

    }

}
