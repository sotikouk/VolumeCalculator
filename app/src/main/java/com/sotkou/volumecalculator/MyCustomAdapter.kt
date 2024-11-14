package com.sotkou.volumecalculator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyCustomAdapter(private val context: Context, private val gridItems:List<Shape>)
    :ArrayAdapter<Shape>(context,0,gridItems) {
        //context: Απαραίτητο για την πρόσβαση σε resources και layouts
        //0: Το ID για το προκατασκευασμένο layout αρχείο.
        // Χρησιμοποιούμε 0 λόγω του ότι θα βάλουμε το δικό μας layout που χρησιμοποιήσαμε.
        //gridItems: Η λίστα των Shape αντικειμένων που θα προσαρμόσουμε με τον adapter και θα εμφανίσουμε στο GridView.

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var itemView = convertView // Το View που θα επιστρέψουμε
        var holder: ViewHolder // Το ViewHolder που δημιουργήσαμε εμείς! Οχι του androidx !

        if (convertView == null) {
            itemView = LayoutInflater.from(context)
                .inflate(R.layout.grid_item_layout, parent, false)

            // Δημιουργούμε και αρχικοποιούμε το viewHolder
            holder = ViewHolder()
            holder.textView = itemView.findViewById(R.id.textView)
            holder.imageView = itemView.findViewById(R.id.imageView)

            // Συνδέουμε το αντικείμενο ViewHolder με το view που δημιουργήσαμε
            // Αποφεύγουμε την ανάγκη να δημιουργούμε ενα νέο ViewHolder κάθε φορά
            itemView.tag = holder
        } else {
            holder = itemView?.tag as ViewHolder
        }

        // Γεμίζουμε δεδομένα στα views
        val currentItem = gridItems[position]
        holder.imageView.setImageResource(currentItem.shapeImage)
        holder.textView.text = currentItem.shapeName

        return itemView!! // Το !! για not null


    }

    // Εσωτερική κλάση
    // Για καλύτερη απόδοση και πιο ομαλό scrolling προτείνεται το ViewHolder σχεδιαστικό πρότυπο.
    // Χρησιμεύει ως container των items μειώνοντας τον αριθμό findViewById() κλήσεων
    // ώστε να αυξήσουμε την απόδοση.
        private class ViewHolder{
            lateinit var imageView: ImageView
            lateinit var textView: TextView
        }
}