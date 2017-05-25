package ng.com.iqubesolutions.drinkshub.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ng.com.iqubesolutions.drinkshub.R;
import ng.com.iqubesolutions.drinkshub.helper.UIHelper;
import ng.com.iqubesolutions.drinkshub.model.Item;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class RecyclerAdapter extends RecyclerViewAdapter<RecyclerAdapter.ItemViewHolder> {

    private final LayoutInflater layoutInflater;

    public Context context;

    private ItemViewHolder holder;

    public RecyclerAdapter(final Context context, ArrayList<Item> items) {
        super();

        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;

    }


    @Override
    public ItemViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.list_item, parent, false);

        return new ItemViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final Item item) {
        holder.bindData(item);
        String id = "";
        holder.setTag(id);
        this.holder = holder;
        
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {

       /* @Bind(R.id.text_company_name) TextView companyNameTextView;
        @Bind(R.id.text_share_type) TextView shareTypeTextView;
        @Bind(R.id.card_view) CardView cardView;
        @Bind(R.id.text_time) TextView timeTextView;
        @Bind(R.id.text_description) TextView descriptionTextView;
        @Bind(R.id.text_count) TextView countTextView;*/

        Context context;

        View view;

        public ItemViewHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            this.view = itemView;
            ButterKnife.bind(this, itemView);
        }

        public void bindData(final Item item) {

            Bitmap bitmap = BitmapFactory.decodeResource( context.getResources(), item.getImageId());

            //userImage.setImageBitmap(UIHelper.getCircularBitmapWithWhiteBorder(bitmap, 3));

        }

        public void setTag(String string){
            this.view.setTag( string);
        }
        public String getTag(){
           return this.view.getTag().toString();
        }

    }

}