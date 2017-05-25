package ng.com.iqubesolutions.drinkshub.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ng.com.iqubesolutions.drinkshub.R;

import static android.content.ContentValues.TAG;
import static android.graphics.PorterDuff.Mode;

public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.ViewHolder> {

    String[] titles;
    TypedArray icons;
    Context context;
    public  static int selected_item = 0;

    // The default constructor to receive titles,icons and context from MainActivity.
    public NavigationDrawerAdapter(String[] titles , TypedArray icons , Context context){

        this.titles = titles;
        this.icons = icons;
        this.context = context;
    }

    /**
     *Its a inner class to NavigationDrawerAdapter Class.
     *This ViewHolder class implements View.OnClickListener to handle click events.
     *If the itemType==1 ; it implies that the view is a single row_item with TextView and ImageView.
     *This ViewHolder describes an item view with respect to its place within the RecyclerView.
     *For every item there is a ViewHolder associated with it .
     */

    public class ViewHolder extends RecyclerView.ViewHolder  {

        TextView navTitle, navCounter;
        ImageView navIcon;
        Context context;
        RelativeLayout layout;
        View view;
        LinearLayout counterLayout;

        public ViewHolder(View drawerItem, Context context){

            super(drawerItem);


            this.context = context;

            navCounter = (TextView) itemView.findViewById(R.id.tv_NavCounter);
            navTitle = (TextView) itemView.findViewById(R.id.tv_NavTitle);
            navIcon = (ImageView) itemView.findViewById(R.id.iv_NavIcon);
            layout = (RelativeLayout) itemView.findViewById(R.id.drawer_row_layout);
            //counterLayout = (LinearLayout) itemView.findViewById(R.id.counter_layout);
            view = itemView.findViewById(R.id.bottom_line);
            navIcon.setColorFilter(ContextCompat.getColor(context, R.color.light_grey) , Mode.MULTIPLY);
        }
    }

    /**
     *This is called every time when we need a new ViewHolder and a new ViewHolder is required for every item in RecyclerView.
     *Then this ViewHolder is passed to onBindViewHolder to display items.
     */

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemLayout = layoutInflater.inflate(R.layout.nav_drawer_row, null);
        return new ViewHolder(itemLayout, context);
    }

    /**
     *This method is called by RecyclerView.Adapter to display the data at the specified position.
     *This method should update the contents of the itemView to reflect the item at the given position.
     *So here , if position!=0 it implies its a row_item and we set the title and icon of the view.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if(position == 0){
        }
            holder.navCounter.setVisibility(View.GONE);
        if(position == selected_item ){
            if (position != 2 || holder.navTitle.getText().toString().equals("Accounts")){
                holder.navTitle.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
                holder.navIcon.setColorFilter(ContextCompat.getColor(context, R.color.colorAccent), Mode.MULTIPLY);
                holder.layout.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
            }

        } else {
            holder.navTitle.setTextColor(Color.BLACK);
            holder.layout.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
            holder.navIcon.setColorFilter( ContextCompat.getColor(context, R.color.gray_bg) , Mode.MULTIPLY);
        }

        if ( position != 0 ){
            switch (position){
                /*case 4:{
                    holder.navCounter.setVisibility(View.GONE);
                    //if count is greater than zero
                    holder.navCounter.setText("3");
                    holder.navCounter.setVisibility(View.VISIBLE);
                }*/

            }
            holder.navTitle.setText(titles[position - 1]);
            holder.navIcon.setImageResource(icons.getResourceId(position-1, -1));

        }else{
            holder.view.setVisibility(View.VISIBLE);
            holder.navTitle.setText("Drinks");
            holder.navTitle.setTextColor(ContextCompat.getColor(context, R.color.site_blue));
        }
    }

    /**
     *It returns the total no. of items . We +1 count to include the header view.
     *So , it the total count is 5 , the method returns 6.
     *This 6 implies that there are 5 row_items and 1 header view with header at position zero.
     */

    @Override
    public int getItemCount() {

        return titles.length + 1;
    }


    /**
     *This methods returns 0 if the position of the item is '0'.
     *If the position is zero its a header view and if its anything else
     *its a row_item with a title and icon.
     */

    @Override
    public int getItemViewType(int position) {

        if (position == 0 ) {

            return 0;

        } else {

            return 1;
        }
    }


}