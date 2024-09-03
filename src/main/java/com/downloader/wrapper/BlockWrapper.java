package com.downloader.wrapper;

import com.downloader.services.IBlock;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BlockWrapper<N> {
    private N number;
    private IBlock internal;
}
