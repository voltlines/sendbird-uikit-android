package com.sendbird.uikit.activities.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.Reaction;
import com.sendbird.uikit.BR;
import com.sendbird.uikit.consts.ClickableViewIdentifier;
import com.sendbird.uikit.consts.MessageGroupType;
import com.sendbird.uikit.interfaces.OnItemClickListener;
import com.sendbird.uikit.interfaces.OnItemLongClickListener;
import com.sendbird.uikit.widgets.EmojiReactionListView;
import com.sendbird.uikit.widgets.OtherFileMessageView;

import java.util.List;
import java.util.Map;

public final class OtherFileMessageViewHolder extends GroupChannelMessageViewHolder {
    private final EmojiReactionListView emojiReactionListView;

    OtherFileMessageViewHolder(@NonNull ViewDataBinding binding, boolean useMessageGroupUI) {
        super(binding, useMessageGroupUI);
        emojiReactionListView = ((OtherFileMessageView) binding.getRoot()).getBinding().rvEmojiReactionList;
        final OtherFileMessageView root = (OtherFileMessageView) binding.getRoot();
        clickableViewMap.put(ClickableViewIdentifier.Chat.name(), root.getBinding().contentPanelWithReactions);
        clickableViewMap.put(ClickableViewIdentifier.Profile.name(), root.getBinding().ivProfileView);
        clickableViewMap.put(ClickableViewIdentifier.QuoteReply.name(), root.getBinding().quoteReplyPanel);
    }

    @Override
    public void bind(BaseChannel channel, @NonNull BaseMessage message, MessageGroupType messageGroupType) {
        binding.setVariable(BR.channel, channel);
        binding.setVariable(BR.message, message);
        binding.setVariable(BR.messageGroupType, messageGroupType);
        binding.setVariable(BR.highlightInfo, highlight);
    }

    @Override
    public void setEmojiReaction(List<Reaction> reactionList,
                                 OnItemClickListener<String> emojiReactionClickListener,
                                 OnItemLongClickListener<String> emojiReactionLongClickListener,
                                 View.OnClickListener moreButtonClickListener) {
        emojiReactionListView.setReactionList(reactionList);
        emojiReactionListView.setEmojiReactionClickListener(emojiReactionClickListener);
        emojiReactionListView.setEmojiReactionLongClickListener(emojiReactionLongClickListener);
        emojiReactionListView.setMoreButtonClickListener(moreButtonClickListener);
    }

    @Override
    public Map<String, View> getClickableViewMap() {
        return clickableViewMap;
    }
}
