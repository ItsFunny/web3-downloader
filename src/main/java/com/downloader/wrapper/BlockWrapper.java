package com.downloader.wrapper;

import com.downloader.services.IBlock;
import com.downloader.services.IRuleBody;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BlockWrapper<N> implements IRuleBody {
    private N number;
    private IBlock internal;
}
